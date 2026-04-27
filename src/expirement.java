class Experiment {

    long measureSortTime(int[] arr, String type, Sorter sorter) {
        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(copy);
        } else {
            sorter.advancedSort(copy);
        }

        long end = System.nanoTime();
        return end - start;
    }

    long measureSearchTime(int[] arr, int target, Searcher searcher) {
        long start = System.nanoTime();

        searcher.search(arr, target);

        long end = System.nanoTime();
        return end - start;
    }

    void runAllExperiments() {
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            int[] arr = sorter.generateRandomArray(size);

            sorter.advancedSort(arr); // обязательно для binary search

            long t1 = measureSortTime(arr, "basic", sorter);
            long t2 = measureSortTime(arr, "advanced", sorter);
            long t3 = measureSearchTime(arr, arr[size / 2], searcher);

            System.out.println("Size: " + size);
            System.out.println("Selection (rec): " + t1);
            System.out.println("Quick (rec): " + t2);
            System.out.println("Binary (rec): " + t3);
            System.out.println("--------------------");
        }
    }
}