#!/bin/bash
for FILE in *; do
	gnuplot <<- EOF
		set grid
		set logscale xy
		set term png
		set output "xyLogPlot${FILE}.png" 
		set table "xyLogPlot${FILE}.dat"
		plot "${FILE}" w lp
	EOF
done