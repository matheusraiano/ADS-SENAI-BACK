
const API_URL = "http://54.83.161.35:8080/usuarios";

const formUsuario = document.getElementById("formUsuario");
const nome = document.getElementById("nome");
const buscarId = document.getElementById("buscarId");

const btnSalvar = document.getElementById("btnSalvar");
const btnLimpar = document.getElementById("btnLimpar");
const btnBuscar = document.getElementById("btnBuscar");
const btnListar = document.getElementById("btnListar");

const listaUsuarios = document.getElementById("listaUsuarios");
const mensagemFormulario = document.getElementById("mensagemFormulario");
const mensagemLista = document.getElementById("mensagemLista");

// Guarda o ID do usuário que está sendo editado.
// Se for null, o formulário fará um cadastro.
let usuarioEditandoId = null;

// Exibe mensagens de sucesso ou erro.
function exibirMensagem(elemento, texto, tipo) {
    elemento.textContent = texto;
    elemento.className = tipo;
}

// Limpa o formulário e volta para o modo de cadastro.
function limparFormulario() {
    formUsuario.reset();
    usuarioEditandoId = null;
    btnSalvar.textContent = "Cadastrar Usuário";

    exibirMensagem(mensagemFormulario, "", "");
}

// Converte a resposta HTTP em dados JSON.
function verificarResposta(resposta) {
    if (!resposta.ok) {
        throw new Error(`Erro HTTP: ${resposta.status}`);
    }

    return resposta.json();
}

// Lista todos os usuários.
function listarUsuarios() {
    mensagemLista.textContent = "Carregando usuários...";

    fetch(API_URL)
        .then(verificarResposta)
        .then(usuarios => {
            listaUsuarios.innerHTML = "";

            usuarios.forEach(usuario => {
                const linha = document.createElement("tr");

                const colunaId = document.createElement("td");
                colunaId.textContent = usuario.id;

                const colunaNome = document.createElement("td");
                colunaNome.textContent = usuario.nome;

                const colunaAcoes = document.createElement("td");

                const btnEditar = document.createElement("button");
                btnEditar.type = "button";
                btnEditar.textContent = "Editar";
                btnEditar.className = "botao-editar";
                btnEditar.dataset.acao = "editar";
                btnEditar.dataset.id = usuario.id;

                const btnExcluir = document.createElement("button");
                btnExcluir.type = "button";
                btnExcluir.textContent = "Excluir";
                btnExcluir.className = "botao-excluir";
                btnExcluir.dataset.acao = "excluir";
                btnExcluir.dataset.id = usuario.id;

                colunaAcoes.append(btnEditar, btnExcluir);

                linha.append(colunaId, colunaNome, colunaAcoes);
                listaUsuarios.appendChild(linha);
            });

            exibirMensagem(
                mensagemLista,
                usuarios.length > 0
                    ? "Usuários carregados com sucesso!"
                    : "Nenhum usuário cadastrado.",
                "sucesso"
            );
        })
        .catch(erro => {
            console.error("Erro ao listar usuários:", erro);

            exibirMensagem(
                mensagemLista,
                "Não foi possível carregar os usuários.",
                "erro"
            );
        });
}

// Cadastra ou atualiza um usuário.
formUsuario.addEventListener("submit", function(evento) {
    evento.preventDefault();

    const nomeUsuario = nome.value.trim();

    if (!nomeUsuario) {
        exibirMensagem(
            mensagemFormulario,
            "Digite o nome do usuário.",
            "erro"
        );
        return;
    }

    const usuario = {
        nome: nomeUsuario
    };

    // Se houver um ID, atualiza.
    // Caso contrário, cadastra.
    const estaEditando = usuarioEditandoId !== null;

    const url = estaEditando
        ? `${API_URL}/${usuarioEditandoId}`
        : API_URL;

    const metodo = estaEditando ? "PUT" : "POST";

    fetch(url, {
        method: metodo,
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
    })
        .then(verificarResposta)
        .then(dados => {
            exibirMensagem(
                mensagemFormulario,
                estaEditando
                    ? "Usuário atualizado com sucesso!"
                    : "Usuário cadastrado com sucesso!",
                "sucesso"
            );

            limparFormulario();
            listarUsuarios();
        })
        .catch(erro => {
            console.error("Erro ao salvar usuário:", erro);

            exibirMensagem(
                mensagemFormulario,
                "Não foi possível salvar o usuário.",
                "erro"
            );
        });
});

// Busca um usuário pelo ID.
btnBuscar.addEventListener("click", function() {
    const id = buscarId.value.trim();

    if (!id || !Number.isInteger(Number(id)) || Number(id) < 1) {
        exibirMensagem(
            mensagemLista,
            "Digite um ID válido.",
            "erro"
        );
        return;
    }

    fetch(`${API_URL}/${id}`)
        .then(verificarResposta)
        .then(usuario => {
            if (!usuario) {
                exibirMensagem(
                    mensagemLista,
                    "Usuário não encontrado.",
                    "erro"
                );
                return;
            }

            // Preenche o formulário para permitir a edição.
            usuarioEditandoId = usuario.id;
            nome.value = usuario.nome;
            btnSalvar.textContent = "Salvar Alterações";

            exibirMensagem(
                mensagemFormulario,
                `Editando o usuário ${usuario.id}. Altere o nome e salve.`,
                "sucesso"
            );

            exibirMensagem(
                mensagemLista,
                `Usuário encontrado: ${usuario.nome} (ID ${usuario.id}).`,
                "sucesso"
            );

            formUsuario.scrollIntoView({
                behavior: "smooth",
                block: "start"
            });
        })
        .catch(erro => {
            console.error("Erro ao buscar usuário:", erro);

            exibirMensagem(
                mensagemLista,
                "Não foi possível buscar o usuário.",
                "erro"
            );
        });
});

// Trata os botões Editar e Excluir da tabela.
listaUsuarios.addEventListener("click", function(evento) {
    const botao = evento.target.closest("button[data-acao]");

    if (!botao) {
        return;
    }

    const id = botao.dataset.id;
    const acao = botao.dataset.acao;

    if (acao === "editar") {
        buscarId.value = id;
        btnBuscar.click();
    }

    if (acao === "excluir") {
        excluirUsuario(id);
    }
});

// Exclui um usuário pelo ID.
function excluirUsuario(id) {
    const confirmar = confirm(
        `Tem certeza de que deseja excluir o usuário ${id}?`
    );

    if (!confirmar) {
        return;
    }

    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(resposta => {
            if (!resposta.ok) {
                throw new Error(`Erro HTTP: ${resposta.status}`);
            }

            exibirMensagem(
                mensagemLista,
                "Usuário excluído com sucesso!",
                "sucesso"
            );

            // Se o usuário excluído estava sendo editado,
            // limpa o formulário.
            if (String(usuarioEditandoId) === String(id)) {
                limparFormulario();
            }

            listarUsuarios();
        })
        .catch(erro => {
            console.error("Erro ao excluir usuário:", erro);

            exibirMensagem(
                mensagemLista,
                "Não foi possível excluir o usuário.",
                "erro"
            );
        });
}

// Limpa o formulário.
btnLimpar.addEventListener("click", limparFormulario);

// Atualiza a listagem.
btnListar.addEventListener("click", listarUsuarios);

// Carrega os usuários assim que a página abrir.
listarUsuarios();
