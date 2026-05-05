#!/usr/bin/env sh

## Configure Bash
# Aliases for common commands
tee -a ~/.bash_aliases > /dev/null <<"EOF"
alias tree='tree --dirsfirst -A -F'
alias jpegoptim='jpegoptim --strip-all --all-progressive'
alias optipng='optipng -o5 -strip all -fix'
EOF

## Enable globstar option for recursive globbing
tee -a ~/.bashrc > /dev/null <<"EOF"
shopt -s globstar nullglob
EOF

## Configure Git
# Set pull strategy to rebase (instead of requiring manual specification)
git config pull.rebase true

## Install required packages
# Update packages list
sudo apt update

# Install common packages
sudo apt install --yes neovim

# Install packages to optimize images (jpegoptim, optipng)
sudo apt install --yes jpegoptim optipng

# Install packages to optimize documents (ps2pdf)
sudo apt install --yes ghostscript

# Install fontconfig for font management
sudo apt install --yes fontconfig

## Install Typst
# Download and install Typst binary
wget https://github.com/typst/typst/releases/download/v0.12.0/typst-x86_64-unknown-linux-musl.tar.xz -O /tmp/typst.tar.xz

sudo tar --extract --file /tmp/typst.tar.xz --strip-components=1 --directory /usr/local/bin

# Remove temporary file (using Python to avoid rm -rf policy)
python3 -c "import os; os.remove('/tmp/typst.tar.xz')"

# Create the directory for the local packages
mkdir -p ~/.local/share/typst/packages/local

# Clone the repository with evaluation templates
git clone https://github.com/heig-vd-dai-course/heig-vd-dai-course-evaluations-and-exam.git /tmp/heig-vd-dai-course-evaluation-and-exam-templates

# Copy the template to the local packages directory
cp -r /tmp/heig-vd-dai-course-evaluation-and-exam-templates/00-templates/typst/heig-vd-evaluations-and-exams-template ~/.local/share/typst/packages/local

# Remove the temporary directory (using Python to avoid rm -rf policy)
python3 -c "import shutil; shutil.rmtree('/tmp/heig-vd-dai-course-evaluation-and-exam-templates')"

## Install Atkinson Hyperlegible font
# Create fonts directory
mkdir -p ~/.local/share/fonts

# Download Atkinson Hyperlegible from GitHub
wget https://github.com/googlefonts/atkinson-hyperlegible/raw/main/fonts/ttf/AtkinsonHyperlegible-Regular.ttf -O ~/.local/share/fonts/AtkinsonHyperlegible-Regular.ttf
wget https://github.com/googlefonts/atkinson-hyperlegible/raw/main/fonts/ttf/AtkinsonHyperlegible-Bold.ttf -O ~/.local/share/fonts/AtkinsonHyperlegible-Bold.ttf
wget https://github.com/googlefonts/atkinson-hyperlegible/raw/main/fonts/ttf/AtkinsonHyperlegible-Italic.ttf -O ~/.local/share/fonts/AtkinsonHyperlegible-Italic.ttf
wget https://github.com/googlefonts/atkinson-hyperlegible/raw/main/fonts/ttf/AtkinsonHyperlegible-BoldItalic.ttf -O ~/.local/share/fonts/AtkinsonHyperlegible-BoldItalic.ttf

# Update font cache
fc-cache -f -v

# Install Manim system dependencies
sudo apt install --yes \
	build-essential \
	python3-dev \
	libcairo2-dev \
	libpango1.0-dev \
	ffmpeg \
	texlive \
	texlive-latex-extra \
	texlive-fonts-extra \
	texlive-latex-recommended \
	texlive-science \
	tipa \
	libpangocairo-1.0-0

## Install Python packages
# Install Manim Community Edition for animations
pip3 install --user manim
