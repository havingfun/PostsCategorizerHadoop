#!/bin/bash
#
cd /home/tushar/Documents/lib/
LIBDB=/home/tushar/Documents/lib/jars.txt
LJAR=$(grep -Ev "^#" $LIBDB)
for i in $LJAR
do
cp $i /home/tushar/Documents/lib/
done
ls -la
