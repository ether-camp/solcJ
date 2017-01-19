# solcJ
Solidity compiler binaries, packed into jar for use in ethereumJ


-----
0.4.8
#### Mac

Navigate to solcJ dir, then:

```
export DEST=`pwd`
cd ..
mkdir -p solidity-builds
cd solidity-builds
export DIR=`pwd`
export VERSION="0.4.8"
git clone --recursive https://github.com/ethereum/solidity.git ${DIR}/solidity-${VERSION}
cd ${DIR}/solidity-${VERSION}
git checkout tags/v${VERSION}

# commebnt brew upgrade to speedup
./scripts/install_deps.sh
mkdir build
cd build
cmake .. && make

# Here we fixing links to dynamic libraries inside binaries
# Magic with `otool` and `install_name_tool`
mkdir solc/link
cp solc/solc solc/link/
cp solc/libsoljson.dylib solc/link/
cp libevmasm/libsolevmasm.dylib solc/link
cp libdevcore/libsoldevcore.dylib solc/link
cp libevmasm/libsolevmasm.dylib solc/link
cp libsolidity/libsolidity.dylib solc/link
python ../scripts/fix_homebrew_paths_in_standalone_zip.py solc/link

cp -fR solc/link/* ${DEST}/src/main/resources/native/mac/solc/

#${DEST}/src/main/resources/native/mac/solc/solc --version
```

#### Linux

Navigate to solcJ dir, then:
```
export DEST=`pwd`
cd scripts/linux
```
Open file `Dockerfile` and change version to checkout
Run docker service
Remove prev image
```
cp -f solc ${DEST}/src/main/resources/native/linux/solc/solc

```

#### Windows

Change version in `scripts/win/run.bat`
Navigate to solcJ dir, then:
```
scripts/win/run.bat

```

Grab result from `build\solc\Release\solc.exe` 


#### Final
 * Copy all binaries to solcJ project
 * Update hardcoded version in `SolcVersion.java` class and in `build.gradle`
 * Publish to bintray with: `./gradlew clean jar bintrayUpload -DbintrayUser=XXXX -DbintrayApiKey=YYYY`


-----
0.4.7
#### Mac

Navigate to solcJ dir, then:

```
export DEST=`pwd`
cd ..
mkdir -p solidity-builds
cd solidity-builds
export DIR=`pwd`
export VERSION="0.4.7"
git clone --recursive https://github.com/ethereum/solidity.git ${DIR}/solidity-${VERSION}
cd ${DIR}/solidity-${VERSION}
git checkout tags/v${VERSION}

# commebnt brew upgrade to speedup
./scripts/install_deps.sh
mkdir build
cd build
cmake .. && make

# Here we fixing links to dynamic libraries inside binaries
# Magic with `otool` and `install_name_tool`
mkdir solc/link
cp solc/solc solc/link/
cp solc/libsoljson.dylib solc/link/
cp libevmasm/libsolevmasm.dylib solc/link
cp libdevcore/libsoldevcore.dylib solc/link
cp libevmasm/libsolevmasm.dylib solc/link
cp libsolidity/libsolidity.dylib solc/link
python ../scripts/fix_homebrew_paths_in_standalone_zip.py solc/link

cp -fR solc/link/* ${DEST}/src/main/resources/native/mac/solc/

#${DEST}/src/main/resources/native/mac/solc/solc --version
```

#### Linux

Navigate to solcJ dir, then:
```
export DEST=`pwd`
cd scripts/linux
```
Open file `Dockerfile` and change version to checkout
Run docker service
```
./run.sh
cp -f solc ${DEST}/src/main/resources/native/linux/solc/solc

```

#### Windows

Navigate to solcJ dir, then:
```
set "DEST=%cd%"
set VERSION="0.4.7"
cd ..
mkdir solidity-builds
cd solidity-builds
git clone --recursive https://github.com/ethereum/solidity.git "solidity-%VERSION%"
cd "solidity-%VERSION%"
git checkout "tags/v%VERSION%"
scripts\install_deps.bat
mkdir build
cd build
cmake -G "Visual Studio 14 2015 Win64" ..
cmake --build . --config Release

```

Grab result from `build\solc\Release\solc.exe` 


#### Final
 * Copy all binaries to solcJ project
 * Update hardcoded version in `SolcVersion.java` class and in `build.gradle`
 * Publish to bintray with: `./gradlew clean jar bintrayUpload -DbintrayUser=XXXX -DbintrayApiKey=YYYY`

-----
0.4.6
#### Mac

Navigate to solcJ dir, then:

```
export DEST=`pwd`
cd ..
mkdir -p solidity-builds
cd solidity-builds
export DIR=`pwd`
export VERSION="0.4.6"
git clone --recursive https://github.com/ethereum/solidity.git ${DIR}/solidity-${VERSION}
cd ${DIR}/solidity-${VERSION}
git checkout tags/v${VERSION}

# commebnt brew upgrade to speedup
./scripts/install_deps.sh
mkdir build
cd build
cmake .. && make

# Here we fixing links to dynamic libraries inside binaries
# Magic with `otool` and `install_name_tool`
mkdir solc/link
cp solc/solc solc/link/
cp solc/libsoljson.dylib solc/link/
cp libevmasm/libsolevmasm.dylib solc/link
cp libdevcore/libsoldevcore.dylib solc/link
cp libevmasm/libsolevmasm.dylib solc/link
cp libsolidity/libsolidity.dylib solc/link
python ../scripts/fix_homebrew_paths_in_standalone_zip.py solc/link

cp -fR solc/link/* ${DEST}/src/main/resources/native/mac/solc/

#${DEST}/src/main/resources/native/mac/solc/solc --version
```

#### Linux

Navigate to solcJ dir, then:
```
export DEST=`pwd`
cd scripts/linux
```
Open file `Dockerfile` and change version to checkout
Run docker service
```
./run.sh
cp -f solc ${DEST}/src/main/resources/native/linux/solc/solc

```

#### Windows

Navigate to solcJ dir, then:
```
set "DEST=%cd%"
set VERSION="0.4.6"
cd ..
mkdir solidity-builds
cd solidity-builds
git clone --recursive https://github.com/ethereum/solidity.git "solidity-%VERSION%"
cd "solidity-%VERSION%"
git checkout "tags/v%VERSION%"
scripts\install_deps.bat
mkdir build
cd build
cmake -G "Visual Studio 14 2015 Win64" ..
cmake --build . --config Release

```

Grab result from `build\solc\Release\solc.exe` 


#### Final
 * Copy all binaries to solcJ project
 * Update hardcoded version in `SolcVersion.java` class and in `build.gradle`
 * Publish to bintray with: `./gradlew clean jar bintrayUpload -DbintrayUser=XXXX -DbintrayApiKey=YYYY`
 
-----
0.4.4
#### Mac

Navigate to solcJ dir, then:

```
export DEST=`pwd`
cd ..
mkdir -p solidity-builds
cd solidity-builds
export DIR=`pwd`
export VERSION="0.4.4"
git clone --recursive https://github.com/ethereum/solidity.git ${DIR}/solidity-${VERSION}
cd ${DIR}/solidity-${VERSION}
git checkout tags/v${VERSION}

# commebnt brew upgrade to speedup
./scripts/install_deps.sh
mkdir build
cd build
cmake .. && make
cp -f solc/solc ${DEST}/src/main/resources/native/mac/solc/solc

#${DEST}/src/main/resources/native/mac/solc/solc --version
```

#### Linux

Navigate to solcJ dir, then:
```
export DEST=`pwd`
cd scripts/linux
```
Open file `run.sh` and change version to checkout
Run docker service
```
./run.sh
cp -f solc ${DEST}/src/main/resources/native/linux/solc/solc

```

#### Windows

Navigate to solcJ dir, then:
```
set "DEST=%cd%"
set VERSION="0.4.4"
cd ..
mkdir solidity-builds
cd solidity-builds
git clone --recursive https://github.com/ethereum/solidity.git "solidity-%VERSION%"
cd "solidity-%VERSION%"
git checkout "tags/v%VERSION%"
scripts\install_deps.bat
mkdir build
cd build
cmake -G "Visual Studio 14 2015 Win64" ..
cmake --build . --config Release

```

Grab result from `build\solc\Release\solc.exe` 


#### Final
 * Copy all binaries to solcJ project
 * Update hardcoded version in `SolcVersion.java` class and in `build.gradle`
 * Publish to bintray with: `./gradlew clean jar bintrayUpload -DbintrayUser=XXXX -DbintrayApiKey=YYYY`

-----
0.4.3

#### Linux
https://github.com/rainbeam/solidity-static/

#### Win
 - Follow wiki
 - add dlls
 - verify on blank Win7 without installed VC distribution packages (even once)

#### Mac

Follow wiki

-----

0.4.2

#### Linux
https://github.com/rainbeam/solidity-static/

#### Win
https://github.com/ethereum/solidity/releases/tag/v0.4.2

#### Mac
```
brew install cpp-ethereum
brew linkapps cpp-ethereum
which solc
```

-----
