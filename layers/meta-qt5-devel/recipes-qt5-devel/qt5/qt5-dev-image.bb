DESCRIPTION = "Qt5 dev tools image"
LICENSE = "MIT"

#inherit core-image-sato
inherit core-image

IMAGE_FEATURES += "splash ssh-server-dropbear debug-tweaks"
IMAGE_FSTYPES += "rpi-sdimg"

CORE_IMAGE_EXTRA_INSTALL += "mc sshd htop git tmux minicom"