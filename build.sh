#!/bin/bash
set -x

docker build -t poky-thud .

docker run --rm -it -v ${PWD}:/yocto --security-opt seccomp:unconfined  \
    --workdir=/yocto poky-thud bash
    #\bash /work-cuteradio/run_in_docker.sh
