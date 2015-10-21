#!/bin/bash
for FILE in *; do
	gnuplot <<- EOF
		set grid
		set logscale y
		set term png
		set output "logPlot${FILE}.png" 
		plot "${FILE}" w lp
	EOF
done