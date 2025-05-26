console.log("Welcome to the Community Portal");
window.onload = () => alert("The page has fully loaded!");
const sampleEventName = "Sample Event";
const sampleEventDate = "2025-06-01";
let sampleSeats = 10;
console.log(`${sampleEventName} on ${sampleEventDate}, Seats: ${sampleSeats}`);
sampleSeats--;
class Event {
  constructor(name, date, seats, category) {
    this.name = name;
    this.date = date;
    this.seats = seats;
    this.category = category;
  }
  checkAvailability() {
    return this.seats > 0 && new Date(this.date) >= new Date();
  }
}
let events = [
  new Event("Jazz Night", "2025-07-20", 50, "Music"),
  new Event("Painting Workshop", "2025-08-12", 0, "Art"),
  new Event("Tech Meetup", "2025-09-05", 30, "Tech")
];
events.push(new Event("Baking Class", "2025-06-20", 15, "Art"));
const musicEvents = events.filter(e => e.category === "Music");
const formatted = events.map(e => `📅 ${e.name} on ${e.date}`);
function addEvent(name, date, seats, category) {
  events.push(new Event(name, date, seats, category));
}
function registerUser(eventName) {
  try {
    const event = events.find(e => e.name === eventName);
    if (!event || event.seats <= 0) throw new Error("Cannot register");
    event.seats--;
    console.log(`Registered for ${event.name}`);
    trackRegistration(event.category);
    renderEvents();
  } catch (e) {
    console.error(e.message);
  }
}
function filterEventsByCategory(cat) {
  return events.filter(e => e.category === cat);
}
function createCategoryTracker() {
  const count = {};
  return function(category) {
    count[category] = (count[category] || 0) + 1;
    console.log(`Registrations for ${category}: ${count[category]}`);
  };
}
const trackRegistration = createCategoryTracker();
function renderEvents() {
  const container = document.getElementById("eventsContainer");
  const dropdown = document.getElementById("eventSelect");
  container.innerHTML = "";
  dropdown.innerHTML = "";
  events.forEach(event => {
    if (!event.checkAvailability()) return;

    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `
      <strong>${event.name}</strong><br>
      Date: ${event.date}<br>
      Category: ${event.category}<br>
      Seats: ${event.seats}<br>
      <button class="registerBtn" data-name="${event.name}">Register</button>
    `;
    container.appendChild(card);
    const option = document.createElement("option");
    option.value = event.name;
    option.textContent = event.name;
    dropdown.appendChild(option);
  });
}
renderEvents();
document.addEventListener("click", e => {
  if (e.target.classList.contains("registerBtn")) {
    registerUser(e.target.dataset.name);
  }
});
document.getElementById("categoryFilter").onchange = (e) => {
  const category = e.target.value;
  const filtered = category ? filterEventsByCategory(category) : events;
  document.getElementById("eventsContainer").innerHTML = "";
  filtered.forEach(event => {
    if (!event.checkAvailability()) return;
    const card = document.createElement("div");
    card.className = "event-card";
    card.innerHTML = `<strong>${event.name}</strong><br>Date: ${event.date}<br>Seats: ${event.seats}`;
    document.getElementById("eventsContainer").appendChild(card);
  });
};
document.getElementById("searchInput").addEventListener("keydown", e => {
  if (e.key === "Enter") {
    const keyword = e.target.value.toLowerCase();
    const matched = events.filter(event => event.name.toLowerCase().includes(keyword));
    document.getElementById("eventsContainer").innerHTML = "";
    matched.forEach(event => {
      if (!event.checkAvailability()) return;
      const card = document.createElement("div");
      card.className = "event-card";
      card.innerHTML = `<strong>${event.name}</strong><br>Date: ${event.date}<br>Seats: ${event.seats}`;
      document.getElementById("eventsContainer").appendChild(card);
    });
  }
});
async function fetchEvents() {
  document.getElementById("loading").style.display = "block";
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Fetched mock data:", data.slice(0, 3));
  } catch (err) {
    console.error("Fetch failed:", err);
  } finally {
    document.getElementById("loading").style.display = "none";
  }
}
fetchEvents();
document.getElementById("registrationForm").addEventListener("submit", e => {
  e.preventDefault();
  const form = e.target;
  const name = form.elements.name.value.trim();
  const email = form.elements.email.value.trim();
  const eventName = form.elements.eventSelect.value;
  const errorDiv = document.getElementById("formError");
  errorDiv.textContent = "";
  if (!name || !email || !eventName) {
    errorDiv.textContent = "All fields are required.";
    return;
  }
  const data = { name, email, event: eventName };
  console.log("Submitting form:", data);
  setTimeout(() => {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",
      body: JSON.stringify(data),
      headers: { "Content-Type": "application/json" }
    })
      .then(res => res.json())
      .then(result => {
        alert("Registration successful!");
        registerUser(eventName);
      })
      .catch(err => {
        console.error("Registration error:", err);
        errorDiv.textContent = "Registration failed. Try again.";
      });
  }, 1000);
});
console.log("🛠 Use DevTools to inspect events, form values, and fetch network requests");
$(document).ready(() => {
  $('#registerBtn').click(() => {
    alert('jQuery click handler!');
  });
  $('.event-card').fadeIn();
});
console.log("✅ Frameworks like React allow reusable UI components, efficient updates, and better state management.");

