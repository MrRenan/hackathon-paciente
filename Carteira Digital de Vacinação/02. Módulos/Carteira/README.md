# Documentação dos Serviços - Carteira de Vacinação

Este diretório contém a documentação detalhada dos endpoints relacionados à **Carteira de Vacinação** no contexto da aplicação de vacinação digital.

Cada subpasta representa um endpoint específico do microsserviço de Carteira, com a descrição dos fluxos principais, fluxos de exceção e exemplos de requisições e respostas.

## 📁 Estrutura de Pastas

Carteira 
<br>└── Serviços
<br>│ ├── Atualizar uma vacina aplicada
<br>│ ├── Buscar carteira por CPF
<br>│ ├── Criar carteira de vacinação
<br>│ └── Incluir vacina aplicada

#
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

- Criar uma nova vacina
- Buscar vacina por nome
- Buscar vacina por ID
- Atualizar dados da vacina
- Listar todas as vacinas
- Remover vacina

## 🚧 Observações

- A nomenclatura dos arquivos foi padronizada para facilitar leitura e versionamento.
- Casos de erro seguem a definição atual de MVP: vacina já cadastrada, vacina não encontrada e erro de infraestrutura.
- A documentação é focada exclusivamente no backend. Questões de LGPD, autenticação/autorização e front-end serão tratadas em etapas futuras.

---
