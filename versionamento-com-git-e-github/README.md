# Versionamento de código com git e GitHub 💻

Quando trabalhamos em equipe, não somos apenas aqueles que irão trabalhar no código, e isso pode gerar problemas se os membros da equipe estiverem trabalhando com versões diferentes do código.

Versionar um código é criar o registro histórico das alterações que são feitas nele. E para isso contamos com ferramentas de versionamento.

Ferramentas de versionamento funcionam com dois tipos de repositórios: o local e o remoto.

O repositório local é a nossa máquina, onde fazemos as alterações necessárias no código e, em seguida, enviamos essas alterações para o repositório remoto, onde ficam disponíveis para os demais membros da equipe.

Dessa forma, podemos entender que o repositório remoto sempre abrigará a versão mais atualizada do código.

Existem várias ferramentas de versionamento de código no mercado. A que mais se destaca atualmente é o Git, a ferramenta criada por Linus Torvalds e sua equipe, que funciona como um sistema de versionamento distribuído, sendo um dos mais utilizados nos dias de hoje.

## 📂 Convenções
- ### .gitignore
    - Nesse arquivos são listados as arquivos e pastas que não queremos enviar para versiomento, arquivo e pastas listadas aqui, são desconsirados pela git

- ### gitkeep
    - o git não reconhece pastas vazias, e como convenção, o arquivo gitkeep é criado dentro dessas pastas para que elas sejam reconhecidas pelo git e sejam versionadas normalmente

## ⌨️ Comandos úteis

```
git init - incia um reposiótio git, tornando a pasta seu reposótorio local;

git add  - adiona as alterações ao repositório;

git commit - commita os arquivos, salvando as alterações no repositório local;

git push - envia as alterações para o repositório remoto;

git pull - puxa as alterações do reposito remoto para o local;

git clone - clona um reposiótio remoto para sua maquina;

git restores nome-do-arquivo - restaura o arquivo ao último status salvo

git commit —amend -m ‘nova mensage' - altera a mensagem do último commmit

git checkout -b nome-da-branch - criar uma nova branch;

git checkout <nome da branch> - retorna para branch selecionada

git merge nome-da-branch - mescla a branch nomeada com a branch main

git branch -d nome-da-branch - deleta a branch
```
### Certificado de conclusão

![](./ceritificado-versionamento-de-codigo.png)
