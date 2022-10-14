window.addEventListener("load", function () {

    const lista = document.querySelector('ul');

    const url = 'http://localhost:8080/turnos';
    fetch(url)
        .then(response => {
            return response.json();
        })
        .then(data => {
            data.forEach(turno => {
                const li = document.createElement('li');
                li.innerHTML = `Paciente: ${turno.paciente.apellido}, ${turno.paciente.nombre}.
                                <br>
                                Odontologo: ${turno.odontologo.apellido}, ${turno.odontologo.nombre}. Mat N° ${turno.odontologo.matricula}
                                <br>
                                Fecha y hora: ${turno.fechaTurno}`;
                lista.appendChild(li);

                //creo btn de delete hacia api
                const deleteBtn = document.createElement('button');
                deleteBtn.innerHTML = 'Eliminar';
                li.appendChild(deleteBtn);
                deleteBtn.addEventListener('click', (event) => {

                    const url = 'http://localhost:8080/turnos/' + turno.id;
                    const settings = { method: 'DELETE' }

                    fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                            li.remove();
                            alert('Turno eliminado!');
                        })
                        .catch(error => {
                            alert('Hubo un error ' + error)
                        })
                })
            })
        })
})