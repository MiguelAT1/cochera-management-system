const API = 'http://localhost:8080/api';

function mostrar(data) {
    document.getElementById('resultado').textContent = JSON.stringify(data, null, 2);
}

async function crearVehiculo() {
    const vehiculo = {
        placa: document.getElementById('placa').value,
        propietario: document.getElementById('propietario').value,
        tipo: document.getElementById('tipo').value
    };

    const respuesta = await fetch(`${API}/vehiculos`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(vehiculo)
    });

    mostrar(await respuesta.json());
    listarVehiculos();
}

async function listarVehiculos() {
    const respuesta = await fetch(`${API}/vehiculos`);
    const vehiculos = await respuesta.json();
    const lista = document.getElementById('listaVehiculos');
    lista.innerHTML = '';

    vehiculos.forEach(v => {
        const item = document.createElement('li');
        item.textContent = `${v.placa} - ${v.propietario} - ${v.estado} - visitas: ${v.visitas}`;
        lista.appendChild(item);
    });
}

async function registrarEntrada() {
    await enviarPlaca('/cochera/entrada');
}

async function registrarSalida() {
    await enviarPlaca('/cochera/salida');
}

async function enviarPlaca(ruta) {
    const placa = document.getElementById('placaControl').value;
    const respuesta = await fetch(`${API}${ruta}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ placa })
    });
    mostrar(await respuesta.json());
    listarVehiculos();
}

async function consultarPromocion() {
    const placa = document.getElementById('placaControl').value;
    const respuesta = await fetch(`${API}/cochera/promocion/${placa}`);
    mostrar(await respuesta.json());
}

listarVehiculos();
