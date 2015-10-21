#!/bin/bash
for FILE in *; do
	gnuplot <<- EOF
		set grid
		set term png
		set output "plot${FILE}.png" 
		plot "${FILE}" w lp
	EOF
done