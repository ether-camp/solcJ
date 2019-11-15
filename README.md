# solcJ
Solidity compiler binaries, packed into jar for use in Java based projects.

## :no_entry: Deprecated :no_entry:
This project is not supported anymore. If you have any question or would like to contribute find us on [Gitter](https://gitter.im/ethereum/ethereumj).

---

Jars are available at:
https://bintray.com/ethereum/maven/org.ethereum.solcJ-all/

Can be included in gradle via:
```
compile 'org.ethereum:solcJ-all:0.5.7'
```

We use jar in EthereumJ project, where we add addition layer of classes to interact with `solc`:

https://github.com/ethereum/ethereumj/tree/develop/ethereumj-core/src/main/java/org/ethereum/solidity/compiler

And then we use code snippet for compilation:

```
String contractSrc =
    "pragma solidity ^0.5.7;\n" +
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
