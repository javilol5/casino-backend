function register() {
    fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: document.getElementById("regUser").value,
            password: document.getElementById("regPass").value
        })
    })
        .then(r => r.json())
        .then(data => {
            document.getElementById("result").innerHTML =
                "✅ Cuenta creada: <b>" + data.username + "</b>";
        })
        .catch(() => {
            document.getElementById("result").innerHTML =
                "❌ Error al registrar";
        });
}

function login() {
    fetch("http://localhost:8080/api/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            username: document.getElementById("logUser").value,
            password: document.getElementById("logPass").value
        })
    })
        .then(r => {
            if (!r.ok) throw new Error();
            return r.json();
        })
        .then(data => {
            document.getElementById("result").innerHTML =
                "🎉 Bienvenido <b>" + data.username + "</b> | 💰 Saldo: " + data.saldo;
        })
        .catch(() => {
            document.getElementById("result").innerHTML =
                "❌ Login incorrecto";
        });
}