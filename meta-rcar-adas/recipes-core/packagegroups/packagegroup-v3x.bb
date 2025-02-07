DESCRIPTION = "V3x/V4x specific packages"

LICENSE = "BSD-3-Clause & GPLv2+ & LGPLv2+"

inherit packagegroup

PACKAGES = " \
    packagegroup-v3x \
"

CPURTT_PKGS_condor = " \
    kernel-module-cpurttdrv \
    kernel-module-cpurttdrv2 \
"
CPURTT_PKGS_eagle = " \
    kernel-module-cpurttdrv \
    kernel-module-cpurttdrv2 \
"
CPURTT_PKGS_falcon = ""

CPURTT_PKGS_whitehawk = " \
    kernel-module-cpurttdrv3 \
"

UDEV_RULES_rcar-v3x = ""
UDEV_RULES_rcar-v4x = "udev-rules-cpuhotplug"

GFX_PKGS_rcar-v3x = ""
GFX_PKGS_rcar-v4x = " \
    kernel-module-gles \
    gles-user-module \
    libegl \
    libgles2 \
"

# V3x common packages: CMEM, CV lib, MMNGR
RDEPENDS_packagegroup-v3x = " \
    kernel-module-uio-pdrv-genirq \
    kernel-module-cmemdrv \
    kernel-module-cmemdrv-dev \
    kernel-module-mmngr \
    kernel-module-mmngrbuf \
    mmngr-user-module \
    mmngrbuf-user-module \
    udev-rules-cvlib \
    linux-renesas-uapi \
    bsp-config \
    capture \
    ${CPURTT_PKGS} \
    kernel-module-qos \
    qosif-user-module \
    qosif-tp-user-module \
    ${UDEV_RULES} \
    ${GFX_PKGS} \
"

# Remove MMNGR driver and library for V4H due to compilation error
# with Kernel v5.10.41 in V4x
RDEPENDS_packagegroup-v3x_remove_rcar-v4x = " \
    kernel-module-mmngr \
    kernel-module-mmngrbuf \
    mmngr-user-module \
    mmngrbuf-user-module \
"
