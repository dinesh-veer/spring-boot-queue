// ==========================================
// Java 25 Features Documentation
// script.js
// ==========================================

// Smooth scrolling for internal links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener("click", function (e) {

        e.preventDefault();

        const target = document.querySelector(this.getAttribute("href"));

        if (target) {
            target.scrollIntoView({
                behavior: "smooth"
            });
        }
    });
});

// ==========================================
// Active Navigation Menu
// ==========================================

const currentPage = window.location.pathname.split("/").pop();

document.querySelectorAll("nav a").forEach(link => {

    const href = link.getAttribute("href");

    if (href === currentPage || (currentPage === "" && href === "index.html")) {

        link.classList.add("active");

    }

});

// ==========================================
// Back To Top Button
// ==========================================

const backToTop = document.createElement("button");

backToTop.innerHTML = "↑";

backToTop.id = "backToTop";

document.body.appendChild(backToTop);

backToTop.style.position = "fixed";
backToTop.style.right = "25px";
backToTop.style.bottom = "25px";
backToTop.style.width = "45px";
backToTop.style.height = "45px";
backToTop.style.border = "none";
backToTop.style.borderRadius = "50%";
backToTop.style.cursor = "pointer";
backToTop.style.fontSize = "20px";
backToTop.style.background = "#2563eb";
backToTop.style.color = "#ffffff";
backToTop.style.display = "none";
backToTop.style.boxShadow = "0 5px 15px rgba(0,0,0,.25)";

window.addEventListener("scroll", () => {

    if (window.scrollY > 300) {

        backToTop.style.display = "block";

    } else {

        backToTop.style.display = "none";

    }

});

backToTop.addEventListener("click", () => {

    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });

});

// ==========================================
// Dark Mode
// ==========================================

const darkButton = document.createElement("button");

darkButton.innerHTML = "🌙";

darkButton.id = "themeToggle";

document.querySelector("header").appendChild(darkButton);

darkButton.style.marginLeft = "20px";
darkButton.style.padding = "8px 12px";
darkButton.style.border = "none";
darkButton.style.borderRadius = "6px";
darkButton.style.cursor = "pointer";
darkButton.style.fontSize = "18px";

const darkTheme = {

    "--background": "#0f172a",
    "--card": "#1e293b",
    "--text": "#f8fafc",
    "--secondary": "#f1f5f9",
    "--border": "#334155"

};

const lightTheme = {

    "--background": "#f8fafc",
    "--card": "#ffffff",
    "--text": "#1f2937",
    "--secondary": "#1e293b",
    "--border": "#e5e7eb"

};

const applyTheme = (theme) => {

    Object.keys(theme).forEach(key => {

        document.documentElement.style.setProperty(
            key,
            theme[key]
        );

    });

};

let darkMode = localStorage.getItem("theme") === "dark";

if (darkMode) {

    applyTheme(darkTheme);

    darkButton.innerHTML = "☀️";

}

darkButton.addEventListener("click", () => {

    darkMode = !darkMode;

    if (darkMode) {

        applyTheme(darkTheme);

        darkButton.innerHTML = "☀️";

        localStorage.setItem("theme", "dark");

    } else {

        applyTheme(lightTheme);

        darkButton.innerHTML = "🌙";

        localStorage.setItem("theme", "light");

    }

});

// ==========================================
// Card Hover Animation
// ==========================================

document.querySelectorAll(".card").forEach(card => {

    card.addEventListener("mouseenter", () => {

        card.style.transform = "translateY(-8px)";
        card.style.transition = ".3s";

    });

    card.addEventListener("mouseleave", () => {

        card.style.transform = "translateY(0px)";

    });

});

// ==========================================
// Footer Year
// ==========================================

const year = new Date().getFullYear();

const footer = document.querySelector("footer");

if (footer) {

    footer.innerHTML = `
        <p>© ${year} Dinesh Veer</p>
        <p>Java 25 Features Documentation</p>
    `;

}

// ==========================================
// Console Banner
// ==========================================

console.log(`
===========================================
 Java 25 Features Documentation
 GitHub : https://github.com/dinesh-veer/java-25-features
===========================================
`);