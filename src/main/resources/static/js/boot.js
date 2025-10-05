const out = document.getElementById("boot-text");
const card = document.querySelector(".center-card");

// Generate random fake system logs
const randomBootLines = [
  "Starting system logger daemon...",
  "Mounting local filesystems...",
  "Checking disks: /dev/sda1 clean",
  "Bringing up loopback interface: lo",
  "Starting sshd service...",
  "Starting Network Manager...",
  "Loading ALSA sound driver modules...",
  "Starting cron daemon...",
  "Starting system message bus...",
  "Loading hardware drivers...",
  "Detecting connected devices...",
  "Mounting /dev, /proc, /sys, /run...",
  "Initializing GPU acceleration...",
  "Applying user permissions...",
  "Syncing hardware clock...",
  "Checking swap space...",
  "Loading terminal environment...",
  "Launching chat kernel modules...",
  "Booting web socket services...",
];

const bootLines = randomBootLines.map(line => ({
  text: line,
  color: "white",
  status: Math.random() < 0.9 ? "OK" : "FAIL"
}));

// Add final system ready line
bootLines.push({ text: "System ready. Welcome to Terminal Chat v1.0", color: "green", status: "OK" });

let i = 0;

function showNext() {
  if (i >= bootLines.length) {
    setTimeout(() => card.style.display = "block", 1000);
    return;
  }

  const ln = bootLines[i++];
  const span = document.createElement("span");
  span.className = ln.color;

  const status = ln.status === "OK"
    ? " [ \x1b[32mOK\x1b[0m ]"
    : " [ \x1b[31mFAIL\x1b[0m ]";

  // Create a typing animation
  let j = 0;
  const text = ln.text;
  const typing = setInterval(() => {
    if (j < text.length) {
      span.textContent += text[j++];
    } else {
      clearInterval(typing);
      // Add colored status at the end
      const statusSpan = document.createElement("span");
      statusSpan.className = ln.status === "OK" ? "green" : "red";
      statusSpan.textContent = ln.status === "OK" ? "  [ OK ]" : "  [ FAIL ]";
      out.appendChild(span);
      out.appendChild(statusSpan);
      out.appendChild(document.createElement("br"));
      out.scrollTop = out.scrollHeight;
      setTimeout(showNext, 200 + Math.random() * 400);
    }
  }, 25);
}

// Show blinking cursor
const cursor = document.createElement("span");
cursor.className = "cursor";
out.appendChild(cursor);

// Simulate typing
showNext();

// Chatroom link generation
document.getElementById("join").addEventListener("click", () => {
  const room = document.getElementById("room-input").value.trim();
  if (!room) return alert("Enter room name");

  const link = `${location.origin}/room/${encodeURIComponent(room)}`;
  const a = document.createElement("a");
  a.href = link;
  a.textContent = link;
  a.target = "_blank";

  const area = document.getElementById("link-area");
  area.innerHTML = "Share this link:<br>";
  area.appendChild(a);
});
