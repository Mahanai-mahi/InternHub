window.addEventListener("scroll", function () {
    const navbar = document.querySelector(".navbar");
    if (navbar) {
        navbar.classList.toggle("sticky", window.scrollY > 50);
    }
});

// Reveal cards
const cards = document.querySelectorAll(".card, .feature-card, .stat-box");

window.addEventListener("scroll", revealCards);

function revealCards() {
    const triggerBottom = window.innerHeight * 0.8;

    cards.forEach(card => {
        const cardTop = card.getBoundingClientRect().top;

        if (cardTop < triggerBottom) {
            card.classList.add("show");
        }
    });
}

revealCards();

// Animated Counters
const counters = document.querySelectorAll(".stat-box h2");

counters.forEach(counter => {

    counter.innerText = "0";

    const updateCounter = () => {

        const target = +counter.getAttribute("data-target");
        const current = +counter.innerText;
        const increment = target / 100;

        if (current < target) {
            counter.innerText = Math.ceil(current + increment);
            setTimeout(updateCounter, 20);
        } else {
            counter.innerText = target;
        }
    };

    updateCounter();
});

// ======================
// FETCH INTERNSHIPS
// ======================

fetch("https://internhub-production-dd96.up.railway.app/api/internships")
.then(response => response.json())
.then(data => {

    const container = document.getElementById("internships");

    if (!container) return;

    data.forEach(internship => {

        container.innerHTML += `
            <div class="card">
                <h2>${internship.title}</h2>
                <p><b>Company:</b> ${internship.company}</p>
                <p><b>Duration:</b> ${internship.duration}</p>
                <p><b>Stipend:</b> ₹${internship.stipend}</p>
                <p><b>Skills:</b> ${internship.requiredSkills}</p>
                <p>${internship.description}</p>
            </div>
        `;
    });
})
.catch(error => console.error("Error fetching internships:", error));