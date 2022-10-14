// const listaPtes = [{
//     "apellido": "ManzonPte",
//     "nombre": "LucasPte"
// },
// {
//     "apellido": "ManzonPte2",
//     "nombre": "LucasPte2"
// },
// {
//     "apellido": "ManzonPte3",
//     "nombre": "LucasPte3"
// },
// ]

window.addEventListener("load", function () {

    const lista = document.querySelector('ul');

    const url = 'http://localhost:8080/pacientes';
    fetch(url)
        .then(response => {
            return response.json();
        })
        .then(data => {
            data.forEach(paciente => {

                //creo li para alojar al pte y sus metodos
                const li = document.createElement('li');
                li.innerHTML = `${paciente.apellido}, ${paciente.nombre}`;
                lista.appendChild(li);

                //creo btn de delete hacia api
                const deleteBtn = document.createElement('button');
                deleteBtn.innerHTML = 'Eliminar';
                li.appendChild(deleteBtn);
                deleteBtn.addEventListener('click', (event) => {

                    const url = 'http://localhost:8080/pacientes/' + paciente.id;
                    console.log('id de paciente a eliminar:' + paciente.id);
                    const settings = { method: 'DELETE' }

                    fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                            li.remove();
                            alert('Paciente eliminado!');
                        })
                        .catch(error => {
                            alert('Hubo un error ' + error)
                        })
                })
            })
        })
})