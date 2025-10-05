let stompClient = null;

function connect(username, onReady) {
  const socket = new SockJS('/ws');
  stompClient = Stomp.over(socket);
  stompClient.debug = null; // disable debug logs

  stompClient.connect({}, function (frame) {
    stompClient.subscribe('/topic/room.' + room, function (message) {
      const msg = JSON.parse(message.body);
      renderMessage(msg);
    });
    if (onReady) onReady();
  });
}

function renderMessage(msg) {
  const out = document.getElementById('output');
  const line = document.createElement('div');
  line.className = 'msg-line';

  const from = document.createElement('span');
  from.className = 'msg-from';
  from.textContent = msg.from + ' > ';

  const text = document.createElement('span');
  text.className = 'msg-text';
  text.textContent = msg.text;

  line.appendChild(from);
  line.appendChild(text);
  out.appendChild(line);
  out.scrollTop = out.scrollHeight;
}

async function loadHistory() {
  try {
    const res = await fetch(`/api/history/${encodeURIComponent(room)}`);
    if (!res.ok) return;
    const arr = await res.json();
    arr.forEach(m => renderMessage({ from: m.sender, text: m.text }));
  } catch (e) {
    console.warn('history fetch failed', e);
  }
}

document.addEventListener('DOMContentLoaded', () => {
  const root = document.getElementById('room-root');
  const roomFromDOM = root ? root.dataset.room : null;
  if (roomFromDOM) window.room = roomFromDOM;

  const nameModal = document.getElementById('name-modal');
  const enterBtn = document.getElementById('enter-room');
  const usernameInput = document.getElementById('username');
  const chatArea = document.getElementById('chat-area');
  const msgInput = document.getElementById('message');
  const sendBtn = document.getElementById('send-btn');

  sendBtn.disabled = true;

  enterBtn.addEventListener('click', () => {
    const name = usernameInput.value.trim();
    if (!name) return alert('Please enter your name');

    nameModal.style.display = 'none';
    chatArea.style.display = 'flex';

    connect(name, () => {
      loadHistory();
      sendBtn.disabled = false;
    });

    setTimeout(() => msgInput.focus(), 300);
  });

  sendBtn.addEventListener('click', sendMessage);
  msgInput.addEventListener('keypress', e => {
    if (e.key === 'Enter') sendMessage();
  });

  function sendMessage() {
    const name = usernameInput.value.trim();
    const text = msgInput.value.trim();
    if (!text || !stompClient) return;

    const payload = { from: name, text, room };
    try {
      stompClient.send('/app/chat.sendMessage', {}, JSON.stringify(payload));
    } catch (e) {
      console.error('send failed', e);
      alert('Send failed: ' + e.message);
    }
    msgInput.value = '';
  }
});
