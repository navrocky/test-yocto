DESCRIPTION = "Qt5 dev tools image"
LICENSE = "MIT"

inherit core-image

inherit cmake_qt5

IMAGE_FEATURES += "splash ssh-server-dropbear debug-tweaks package-management x11-base x11-sato hwcodecs tools-debug"
IMAGE_FSTYPES += "rpi-sdimg"

CORE_IMAGE_EXTRA_INSTALL += "mc sshd htop git tmux minicom"

PKG_FONTS = " \
    fontconfig \
    ttf-bitstream-vera \
"

# PKG_MULTIMEDIA = " \
#     alsa-utils \
#     gstreamer1.0-plugins-bad \
#     gstreamer1.0-plugins-base \
#     gstreamer1.0-plugins-good \
#     gstreamer1.0-plugins-ugly \
# "

PKG_QT5 = " \
    qtbase \
"

PKG_QT5_DEV = " \
    qt5-creator \
"

IMAGE_INSTALL += " \
    ${PKG_QT5_DEV} \
"

TOOLCHAIN_HOST_TASK_append = " nativesdk-intltool nativesdk-glib-2.0"
TOOLCHAIN_HOST_TASK_remove_task-populate-sdk-ext = " nativesdk-intltool nativesdk-glib-2.0"

QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'
QB_MEM_qemumips = "-m 256"
