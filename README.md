# IntelliJ plugin for Haskell

Some months ago I started his project because I was learning Haskell and I was missing the nice features of IntelliJ IDEA. First approach
 was to use default way of creating IntelliJ plugin by defining grammar and lexer according to
  [Haskell report](http://www.haskell.org/onlinereport/haskell2010/haskellch10.html). That did not workout because I could not define all 
  the recursiveness. 
  Decided to use grammar and lexer definitions only for tokenizing and parsing Haskell code, so not for syntax checking the code. This is needed for syntax highlighting, all kind of navigation and so on.
  Further Haskell language support is done with the support of the external tools: ghc-mod and haskell-docs.

In the meantime also Atsky started to create [Haskell-idea-plugin](https://github.com/Atsky/haskell-idea-plugin) based on ideah plugin in Kotlin. 
 Looking to their recent changes, they are more focusing on Cabal and debugging support.
 
This plugin is written mainly in Scala and is mentioned not to support GHC/Cabal directly. This plugin support sandbox projects
and expects that the Cabal init/install/build is done on command-line.

# Features
- Syntax highlighting (which can be customized);
- Error/warning highlighting;
- Find Usages of variables/constructors;
- Resolving references of variables (also to library code if library source code is added to project);
- Code completion by resolving references;
- Renaming variables (which first shows preview so refactoring scope can be adjusted);
- View type info from (selected) expression;
- View expression info;
- View quick documentation;
- View quick definition;
- Structure view;
- Navigate to declaration (called `Class` in IntelliJ menu);
- Navigate to identifier (called `Symbol` in IntelliH menu);
- Code completion by looking to import declarations(`hiding` and `qualified` are not supported yet);

A lot of features are with the help of ghc-mod(i)!!

# TODO:
- Inspection by hlint;
- Integration of stylish-haskell; 
- Integration of hsimport;
- Smart completion if that is achievable :-)
- Hole driven development support;
- Some quick-fixes;
- Setting scope while refactoring;
- Code formatting (maybe use `hindent` or `haskell-formatter` as helper);

# Getting started: 
- Cabal install ghc-mod and haskell-docs;
- Set file paths to ghc-mod, ghc-modi and haskell-docs in `Settings/Haskell`;
- Be sure in Settings/Filetypes that `Haskell language file` is registered with pattern `*.hs` and `Literate Haskell language file` with pattern `*.lhs`; 
- First install your project in a Cabal sandbox (be sure that Haddock documentation is generated, see [haskell-docs](https://github.com/chrisdone/haskell-docs)). 
- After project is installed in sandbox, create Haskell project in IntelliJ by using `File`/`Open` from IntelliJ menu;
- Select `No SDK` in Project Setting;
- Select in `Modules Settings` which folders to exclude (like .cabal-sandbox and dist) and which folders are `Source` and `Test` (normally src and test).
- To get nice navigation features: add for libraries, Prelude(base and integer-gmp packages) the source root directories to project in `Project Settings`/`Libraries`. `cabal get` is useful for getting source code of package;

# Remarks
- IntelliJ has a nice terminal plugin, useful for executing the Cabal commands;
- ghc-mod can not help in library files and if Haskell source file contains not completely valid Haskell (e.g. while typing). In that case I try to solve request by using AST-tree (IntelliJ calls it PSI-tree). 
- Because of ghc-mod issue #275 ghc-mod is used (instead of ghc-modi) for checking syntax of Haskell file;
- Because of ghc-mod issue #362 ghc-mod is used (instead of ghc-modi) for getting symbols of module using `browse` command;
