const getPacientes = async () => {
    const url = 'http://localhost:8080/pacientes';
    return fetch(url)
        .then(response => {
            return response.json();
        })
}

const getOdontologos = async () => {
    const url = 'http://localhost:8080/odontologos';
    return fetch(url)
        .then(response => {
            return response.json();
        })
}

const listaPacientesHardcoded = [
    {
        "id": 1,
        "apellido": "ApellidoPte1",
        "nombre": "NombrePte1"
    },

    {
        "id": 2,
        "apellido": "ApellidoPte2",
        "nombre": "NombrePte2"
    },

    {
        "id": 3,
        "apellido": "ApellidoPte3",
        "nombre": "NombrePte3"
    }
]

const listaOdontologosHardcoded = [
    {
        "id": 1,
        "apellido": "ApellidoOdonto1",
        "nombre": "NombreOdonto1",
        "matricula": "12345"
    },

    {
        "id": 2,
        "apellido": "ApellidoOdonto2",
        "nombre": "NombreOdonto2",
        "matricula": "12345"
    },

    {
        "id": 3,
        "apellido": "ApellidoOdonto3",
        "nombre": "NombreOdonto3",
        "matricula": "12345"
    }
]


window.addEventListener("load", async function () {
    const form = this.document.querySelector("form");

    // inputs version previa, por #id del input, sin traerlos desde la DB
    // const pteInput = this.document.querySelector('#id-paciente-input');
    // const odontologoInput = this.document.querySelector('#id-odontologo-input');

    const listaPacientes = await getPacientes();
    // console.log(listaPacientes);

    const listaOdontologos = await getOdontologos();
    // console.log(listaOdontologos);

    // dropdown de pacientes desde db
    const pacientesDropdown = document.querySelector('#pacientes-dropdown');
    for (const paciente of listaPacientes) {
        const option = document.createElement('option');
        option.value = paciente.id;
        option.innerHTML = `${paciente.apellido}, ${paciente.nombre}`;
        pacientesDropdown.appendChild(option);
    }

    // // dropdown de odontologos desde db
    const odontologosDropdown = document.querySelector('#odontologos-dropdown');
    for (const odontologo of listaOdontologos) {
        const option = document.createElement('option');
        option.value = odontologo.id;
        option.innerHTML = `${odontologo.apellido}, ${odontologo.nombre}. Mat N° ${odontologo.matricula}`;
        odontologosDropdown.appendChild(option);
    }

    // preparo form para submit
    form.addEventListener("submit", function (event) {
        event.preventDefault;

        // traigo ID del pte seleccionado
        const pacienteSeleccionado = pacientesDropdown.options[pacientesDropdown.selectedIndex].value;

        // traigo ID del odontologo seleccionado
        const odontologoSeleccionado = odontologosDropdown.options[odontologosDropdown.selectedIndex].value;

        // traigo fecha desde input
        const dateInput = document.querySelector("#datetime-input");

        const formData = {
            paciente: {
                id: pacienteSeleccionado
            },
            odontologo: {
                id: odontologoSeleccionado
            },
            fechaTurno: dateInput.value
        }

        const url = 'http://localhost:8080/turnos';
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
                alert('Turno agregado!');
            })
            .catch(error => {
                alert('Hubo un error ' + error)
            })
    })
})