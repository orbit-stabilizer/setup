# Steps to setup new machine

1. Install homebrew: `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. Install git: `brew install git`
3. Clone repo
4. Run `chmod +x bootstrap.sh`
4. Run `chmod +x ./packages/*.sh`
5. Run `sh bootstrap.sh`
5. Run `bb install-packages.clj`
6. Profit
