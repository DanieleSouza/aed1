/* Rotinas para heapsort */

int 	parent (int i) { return i / 2; }
int 	left (int i) { return 2 * i; }
int 	right (int i) { return 2 * i + 1; }

void heapify (vetor v, int tam, int i) {
	int l, r, largest, tmp;

	l = left (i);
	r = right (i);

	if ((l <= tam) && (v[l] > v[i])) 
		largest = l;
	else 
		largest = i;

	if ((r <= tam) && (v[r] > v[largest])) 
		largest = r;
	
	if (largest != i) {
		tmp = v[largest];
		v[largest] = v[i];
		v[i] = tmp;
		heapify (v, tam, largest);
	}
}

void build_heap (vetor v, int tam) {
	int i;
	for (i = tam / 2; i; i--)
		heapify (v, tam, i);
}

void heapsort (vetor v, int tam) {
	int i, tmp;
	build_heap (v, tam);
	for (i = tam; i > 1; i--) {
		tmp = v[1];	
		v[1] = v[i];
		v[i] = tmp;
		heapify (v, --tam, 1);
	}
}