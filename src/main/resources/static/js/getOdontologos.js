window.addEventListener("load", function () {

    const lista = document.querySelector('ul');

    const url = 'http://localhost:8080/odontologos';

    fetch(url)
        .then(response => {
            return response.json();
        })
        .then(data => {
            data.forEach(odontologo => {

                //creo li para alojar al odontologo y sus metodos
                const li = document.createElement('li');
                li.innerHTML = `${odontologo.apellido}, ${odontologo.nombre}. Mat N° ${odontologo.matricula}`;
                lista.appendChild(li);

                //creo btn de delete hacia api
                const deleteBtn = document.createElement('button');
                deleteBtn.innerHTML = 'Eliminar';
                li.appendChild(deleteBtn);
                deleteBtn.addEventListener('click', (event) => {

                    const url = 'http://localhost:8080/odontologos/' + odontologo.id;
                    const settings = { method: 'DELETE' }

                    fetch(url, settings)
                        .then(response => response.json())
                        .then(data => {
                            li.remove();
                            alert('Odontologo eliminado!');
                        })
                        .catch(error => {
                            alert('Hubo un error ' + error)
                        })
                })

            })
        })
})
