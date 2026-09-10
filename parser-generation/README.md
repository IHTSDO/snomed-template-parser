## How The Parser was Generated
The Expression Template syntax is defined in ABNF grammar.
There is far better Java support for ANTLR grammar so first we convert the ABNF file to ANTLR.
 
# Convert ABNF to ANTLR
Paste the contents of the ABNF file into the following webpage and hit Translate
http://www.robertpinchbeck.com/abnf_to_antlr/ 

The resulting ANTLR grammar should be saved as a file named 'ExpressionTemplate.txt'
Add the following as the first line of the ExpressionTemplate.txt file:
```
grammar ExpressionTemplate;
```

# Generate the ANTLR Parser
Download the ANTLR java program from https://www.antlr.org/download/antlr-4.13.2-complete.jar

Use the program to generate the Expression Template parser (from the repo root):
```
java -jar antlr-4.13.2-complete.jar -package org.snomed.authoringtemplate.service.generatedlogicalparser -listener -no-visitor parser-generation/ExpressionTemplate.txt -o parser-generation/parser-files
```

Copy the generated `*.java` files into `src/main/java/org/snomed/authoringtemplate/service/generatedlogicalparser/`.
The antlr4-runtime dependency version must match the generator version (currently 4.13.2 from snomed-parent-bom).
