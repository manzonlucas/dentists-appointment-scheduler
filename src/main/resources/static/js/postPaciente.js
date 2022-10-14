window.addEventListener("load", function () {
    const form = this.document.querySelector("form");
    form.addEventListener("submit", function (event) {
        event.preventDefault;
        const formData = {
            nombre: document.querySelector('#nombre-input').value,
            apellido: document.querySelector('#apellido-input').value,
        };

        const url = 'http://localhost:8080/pacientes';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                alert('Paciente agregado!');
            })
            .catch(error => {
                alert('Hubo un error ' + error)
            })
    })
})