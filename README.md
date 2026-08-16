# Steps to set up new machine

1. Install homebrew: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. Install git: `brew install git`
3. Install babaskha: `brew install borkdude/brew/babashka`
4. Clone repo
5. Run `bb install-packages.clj`
6. Install all manual packages
7. Import Raycast config
8. Run the following to setup java after installing openjdk from homebrew:
    sudo ln -sfn /opt/homebrew/opt/openjdk/libexec/openjdk.jdk /Library/Java/JavaVirtualMachines/openjdk.jdk
