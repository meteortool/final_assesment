# Ferramenta Meteor (Versão em Português)
(for English version see below)

O Meteor é ferramenta produto de um trabalho de pesquisa de um mestrado para o curso de computação aplicada do [IPT](<https://ipt.br/ensino/>) (Instituto de Pesquisas Tecnológicas de São Paulo).

Ele funciona como um plugin para a IDE Eclipse desenvolvido para apoiar desenvolvedores na validação do sucesso de uma refatoração do código de testes. Para instalar o Meteor vide as instruções abaixo.

Para que o projeto fosse possível, foi realizado um fork do projeto Pitclipse para que fossem realizadas as alterações necessárias para funcionamento da ferramenta Meteor.

# Autores

O projeto foi desenvolvimento por [Tiago Samuel Rodrigues Teixeira](<https://www.linkedin.com/in/tsrteixeira/>) em conjunto com os professores Eduardo Martins Guerra e Fabio Fagundes Silveira.

| Pesquisador | ORCID |
| --- | --- |
| Tiago Samuel Rodrigues Teixeira | [0009-0006-9960-4729](<https://orcid.org/0009-0006-9960-4729>) |  
| Eduardo Martins Guerra  | [0000-0001-5555-3487](<https://orcid.org/0000-0001-5555-3487>) |
| Fábio Fagundes Silveira | [0000-0002-2063-2959](<https://orcid.org/0000-0002-2063-2959>) | 

# Estudo preliminar (Assessment)

Os dados utilizados para embasamento desse trabalho estão contidos no repositório <https://github.com/meteortool/assessment>.

# Artigo acadêmico

No link (<https://www.mdpi.com/2073-431X/12/11/230>) é possível obter o estudo preliminar realizado para suportar o desenvolvimento desse projeto.

## Instalação

Para instalar o Meteor, você precisará seguir os seguintes passos:

1. Ter a IDE Eclipse instalada em seu ambiente. 
2. Ir em Help > Install New Software ... 
3. Na janela Install clicar em Add...
4. Na janela Add Repository no campo [Name] preencher com Meteor PIT e no campo [URL] (<https://meteortool.github.io/binaries/>).
5. Reinicie o Eclipse.
6. Deverá a opção Meteor no menu da ferramenta Eclipse.
7. O Meteor automaticamente também instala o plugin Pitclipse, não se deve instalar apartadamente.
8. PASSO OPCIONAL: Instalar o CSVEdit2 (<https://marketplace.eclipse.org/content/csvedit2>) no Eclipse para facilitar na exibição dos resultados de testes.

### Recomendações

1. Usar a versão mais recente do Eclipse JEE - o Meteor foi testado e homologado na versão 2023-12 (4.30.0).
2. Remover as instalações do Pitclipse, caso você tenha instalado anteriormente.
3. Caso ocorra algum problema tente usar um workspace novo (limpo)

## Contribuições

Se você encontrar algum problema ou quiser contribuir com o projeto, você pode abrir um issue no GitHub ou enviar um pull request.

## Links úteis

| Descrição | Link |
| --- | --- |
| Artigo acadêmico | <https://www.mdpi.com/2073-431X/12/11/230> |
| **Meteor:** *Todos os repositórios do projeto* | <https://github.com/meteortool> |
| **Meteor Plugin:** *Meteor Eclipse Plugin Download Site* | <https://meteortool.github.io/binaries> | 
| **Meteor Assessement:** *Compilação dos dados do estudo preliminar* | <https://github.com/meteortool/assessment> |
| **Meteor Final Assessement:** *Compilação dos dados do estudo já com a ferramenta finalizada* | <https://github.com/meteortool/final_assessment> |
| **Meteor Binaries:** *Repositório para armazenar os releases do plugin* | <https://github.com/meteortool/binaries> |
| **Meteor Pitclipse:** *Fork do projeto Pitclipse com as contribuições do Meteor* | <https://github.com/meteortool/pitclipse> |
| **Pitclipse:** Repositório original do Pitclipse | <https://github.com/pitest/pitclipse> | 
| **Pitclipse Plugin:** Pitclipse Eclipse Plugin Download Site | <https://marketplace.eclipse.org/content/pitclipse> |

## Licença

O Meteor é licenciado sob a licença MIT.

Se você quiser instalar o plugin Pitclipse original sem as alterações que suportam o Meteor clicar no [link](<https://marketplace.eclipse.org/content/pitclipse>).  

---

# Meteor Tool (English Version)

Meteor is a tool resulting from a master's degree research work for the applied computing course at [IPT](<https://ipt.br/ensino/>) (São Paulo Technological Research Institute).

It works as a plugin for the Eclipse IDE designed to support developers in validating the success of a test code refactoring. To install Meteor, see the instructions below.

To make the project possible, a fork of the Pitclipse project was made to make the necessary changes for the tool's functionality.

# Authors

The project was developed by [Tiago Samuel Rodrigues Teixeira](<https://www.linkedin.com/in/tsrteixeira/>) in collaboration with professors Eduardo Martins Guerra and Fabio Fagundes Silveira.

| Researcher | ORCID |
| --- | --- |
| Tiago Samuel Rodrigues Teixeira | [0009-0006-9960-4729](<https://orcid.org/0009-0006-9960-4729>) | 
| Eduardo Martins Guerra | [0000-0001-5555-3487](<https://orcid.org/0000-0001-5555-3487>) |
| Fábio Fagundes Silveira | [0000-0002-2063-2959](<https://orcid.org/0000-0002-2063-2959>) |

# Preliminary Study (Assessment)

The data used for this study can be found in the repository <https://github.com/meteortool/assessment>.

# Academic Article

In the link (<https://www.mdpi.com/2073-431X/12/11/230>) you can obtain the preliminary study done to support the development of this project.

## Installation

To install the Meteor tool, you need to follow these steps:

1. Have the Eclipse IDE installed on your environment.
2. Go to Help > Install New Software ...
3. In the Install window, click on Add...
4. In the Add Repository window, in the [Name] field, enter "Meteor PIT" and in the [URL] field (<https://meteortool.github.io/binaries/>).
5. Restart Eclipse.
6. You should now see the option Meteor in the Eclipse tool menu.
7. The Meteor tool automatically installs the Pitclipse plugin, so you don't need to install it separately.
8. OPTIONAL STEP: Install the CSVEdit2 plugin in Eclipse (<https://marketplace.eclipse.org/content/csvedit2>) to make it easier to view the results of tests.

### Recommendations

1. Use the latest version of Eclipse JEE - the Meteor tool was tested and homologated in version 2023-12 (4.30.0).
2. Remove any previous installations of Pitclipse, if you had installed it before.
3. If there is any problem, try using a new (clean) workspace.

## Contributions

If you find any problem or want to contribute to the project, you can open an issue on GitHub or send a pull request.

## Useful Links

| Description | Link |
| --- | --- |
| Academic Article | <https://www.mdpi.com/2073-431X/12/11/230> |
| **Meteor:** *All project repositories* | <https://github.com/meteortool> |
| **Meteor Plugin:** *Meteor Eclipse Plugin Download Site* | <https://meteortool.github.io/binaries> |
| **Meteor Assessment:** *Compilation of data from preliminary study* | <https://github.com/meteortool/assessment> |
| **Meteor Final Assessment:** *Compilation of study data already with the finalized tool* | <https://github.com/meteortool/final_assessment> |
| **Meteor Binaries:** *Repository for storing plugin releases* | <https://github.com/meteortool/binaries> |
| **Meteor Pitclipse:** *Fork of Pitclipse project with contributions from Meteor* | <https://github.com/meteortool/pitclipse> |
| **Pitclipse:** Original Pitclipse repository | <https://github.com/pitest/pitclipse> |
| **Pitclipse Plugin:** Pitclipse Eclipse Plugin Download Site | <https://marketplace.eclipse.org/content/pitclipse> |

## License

The Meteor tool is licensed under the MIT license.

If you want to install the original Pitclipse plugin without the changes that support the Meteor tool, click on [this link](<https://marketplace.eclipse.org/content/pitclipse>).
