document.addEventListener("DOMContentLoaded", function () {

    console.log("Skill Exchange Portal Loaded");

    const forms = document.querySelectorAll("form");

    forms.forEach(form => {
        form.addEventListener("submit", function () {

            alert("Processing...");

        });
    });

});