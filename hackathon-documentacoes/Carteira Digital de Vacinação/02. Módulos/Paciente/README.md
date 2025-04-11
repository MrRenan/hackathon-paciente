# Documentação dos Serviços - Paciente

Este diretório contém a documentação detalhada dos endpoints relacionados à entidade **Paciente** no contexto da Carteira Digital de Vacinação.

Cada subpasta representa um endpoint específico do microsserviço de Paciente, com a descrição dos fluxos principais, fluxos de exceção e exemplos de requisições e respostas.

## 📁 Estrutura de Pastas


## 📄 Conteúdo de cada pasta

Cada pasta segue a seguinte estrutura:

| Arquivo                            | Descrição |
|-----------------------------------|-----------|
| `01. Fluxo Principal.md`          | Descreve o fluxo principal de execução do endpoint com diagrama de sequência. |
| `02. Fluxo de excessão - ... .md` | Detalha os cenários de exceção e como são tratados. |
| `requisição.json`                 | Exemplo de payload de entrada da requisição. *(Se aplicável)* |
| `resposta.json`                   | Exemplo de resposta de sucesso do endpoint. |
| `resposta - ... .json`            | Exemplo de resposta de erro, conforme cenário de exceção. |

## ✅ Endpoints Documentados

- Criar um novo paciente
- Buscar paciente por CPF
- Atualizar dados do paciente
- Listar todos os pacientes
- Remover paciente

## 🚧 Observações

- A nomenclatura dos arquivos foi padronizada para facilitar leitura e versionamento.
- Casos de erro seguem a definição atual de MVP: paciente não encontrado e erro de infraestrutura.
- A documentação é focada exclusivamente no backend. Questões de LGPD, autenticação/autorização e front-end serão tratadas em etapas futuras.

---

