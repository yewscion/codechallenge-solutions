#!/usr/bin/env bash

rm -rfv build/
mkdir -pv build/
./bootstrap
cd build/
../configure
make
DESTDIR=test/ make install
tree test
make dist
mv -vt .. *.bz2
echo "Incantation Complete."
