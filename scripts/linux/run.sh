docker build --rm --file=Dockerfile --tag=rainbeam/solidity-static .
  # create a container to copy files from (can't copy from an image)
tmp_container=$(docker create rainbeam/solidity-static sh)
docker cp ${tmp_container}:/usr/local/bin/solc .
docker cp ${tmp_container}:/usr/local/bin/solctest .