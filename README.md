# solcJ
Solidity compiler binaries, packed into jar for use in Java based projects.


---

Jars are available at:
https://bintray.com/ethereum/maven/org.ethereum.solcJ-all/

Can be included in gradle via:
```
compile 'org.ethereum:solcJ-all:0.4.8'
```

We use jar here:

https://github.com/ethereum/ethereumj/tree/develop/ethereumj-core/src/main/java/org/ethereum/solidity/compiler

```
String contractSrc =
    "pragma solidity ^0.4.7;\n" +
            "contract a {" +
            "        function() {throw;}" +
            "}";

SolidityCompiler.Result res = SolidityCompiler.compile(
        contractSrc.getBytes(), true, ABI, BIN, INTERFACE, METADATA);
System.out.println("Out: '" + res.output + "'");
System.out.println("Err: '" + res.errors + "'");
CompilationResult result = CompilationResult.parse(res.output);

CompilationResult.ContractMetadata a = result.contracts.get("a");
CallTransaction.Contract contract = new CallTransaction.Contract(a.abi);
System.out.printf(contract.functions[0].toString());
```