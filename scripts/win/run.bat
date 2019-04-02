set "DEST=%cd%"
set VERSION="0.5.7"
cd ..
mkdir solidity-builds
cd solidity-builds
git clone --recursive https://github.com/ethereum/solidity.git "solidity-%VERSION%"
cd "solidity-%VERSION%"
git checkout "tags/v%VERSION%"
call scripts\install_deps.bat
mkdir build
cd build
cmake -G "Visual Studio 14 2015 Win64" ..
cmake --build . --config Release
