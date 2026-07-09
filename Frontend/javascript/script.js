window.addEventListener("scroll", function(){

    const navbar = document.querySelector(".navbar");

    navbar.classList.toggle("sticky", window.scrollY > 50);

});
const cards = document.querySelectorAll(".card, .feature-card, .stat-box");

window.addEventListener("scroll", revealCards);

function revealCards(){

    const triggerBottom = window.innerHeight * 0.8;

    cards.forEach(card => {

        const cardTop = card.getBoundingClientRect().top;

        if(cardTop < triggerBottom){

            card.classList.add("show");
        }
    });
}

revealCards();

const counters = document.querySelectorAll(".stat-box h2");

counters.forEach(counter => {

    counter.innerText = "0";

    const updateCounter = () => {

        const target = +counter.getAttribute("data-target");

        const current = +counter.innerText;

        const increment = target / 100;

        if(current < target){

            counter.innerText = `${Math.ceil(current + increment)}`;

            setTimeout(updateCounter, 20);

        } else {

            counter.innerText = target;
        }
    };

    updateCounter();
});

window.addEventListener("scroll", function(){

    const navbar = document.querySelector(".navbar");

    navbar.classList.toggle("sticky", window.scrollY > 50);

});

const cards = document.querySelectorAll(".card, .feature-card, .stat-box");

window.addEventListener("scroll", revealCards);

function revealCards(){

    const triggerBottom = window.innerHeight * 0.8;

    cards.forEach(card => {

        const cardTop = card.getBoundingClientRect().top;

        if(cardTop < triggerBottom){

            card.classList.add("show");
        }
    });
}

revealCards();

const counters = document.querySelectorAll(".stat-box h2");

counters.forEach(counter => {

    counter.innerText = "0";

    const updateCounter = () => {

        const target = +counter.getAttribute("data-target");

        const current = +counter.innerText;

        const increment = target / 100;

        if(current < target){

            counter.innerText = `${Math.ceil(current + increment)}`;

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

fetch("http://localhost:8081/api/internships")
.then(response => response.json())
.then(data => {

    const container = document.getElementById("internships");

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
});