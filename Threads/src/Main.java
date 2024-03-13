import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Set<String> runnerIds = Runner.getAllRunnersIDs();

        //firstTask(runnerIds);
        //secondTask(runnerIds);
        //thirdTask(runnerIds);
        //fourthTask(runnerIds);
        //fifthTask(runnerIds);
        sixthTask(runnerIds);

    }

    private static void firstTask(Set<String> runnerIds) {
        long startTime = System.currentTimeMillis();

        // for loop:
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        System.out.println(Runner.getRunnerById(runnerId).getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        /* forEach ------------------------------------
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            runnerIds.forEach(id -> executorService.submit(() -> {
                try {
                    System.out.println(Runner.getRunnerById(id).getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        ----------------------------------------------*/

        System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) / 1000 + " seconds");
    }

    private static void secondTask(Set<String> runnerIds) {
        AtomicInteger startingNumber = new AtomicInteger();
        List<Runner> runners = Collections.synchronizedList(new ArrayList<>());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        Runner runner = Runner.getRunnerById(runnerId);
                        runner.setStartingNumber(startingNumber.incrementAndGet());
                        runners.add(runner);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        runners.sort(Comparator.comparing(Runner::getStartingNumber));
        System.out.println(runners);
    }

    private static void thirdTask(Set<String> runnerIds) {
        AtomicInteger numberTwo = new AtomicInteger();
        List<Runner> allRunners = Collections.synchronizedList(new ArrayList<>());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        Runner newRunner = Runner.Builder.builder()
                                .withName(Runner.getRunnerById(runnerId).getName())
                                .withPersonalId(runnerId)
                                .withStartingNumber(numberTwo.incrementAndGet())
                                .build();

                        allRunners.add(newRunner);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        allRunners.sort(Comparator.comparing(Runner::getStartingNumber));
        allRunners.forEach(System.out::println);
    }

    private static void fourthTask(Set<String> runnerIds) {
        List<Runner> runnersNameBirthDate = new ArrayList<>();

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        int year = (int) Math.floor(Math.random() * (2006 - 1950 + 1) + 1950);
                        int month = (int) Math.floor(Math.random() * 13);
                        int day = (int) Math.floor(Math.random() * 31);

                        Runner runner = Runner.Builder.builder()
                                .withName(Runner.getRunnerById(runnerId).getName())
                                .withBirthDate(LocalDate.of(year, month, day))
                                .build();

                        runnersNameBirthDate.add(runner);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        Map<String, List<Runner>> groupedRunnersByName = runnersNameBirthDate.stream()
                .collect(Collectors.groupingBy(Runner::getName));

        Map<Integer, List<Runner>> groupedRunnersByDate = runnersNameBirthDate.stream()
                .collect(Collectors.groupingBy(runner -> runner.getBirthDate().getMonthValue()));

        System.out.println("Grouped by names:");
        groupedRunnersByName.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("Grouped by month of birth");
        groupedRunnersByDate.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static void fifthTask(Set<String> runnerIds) {
        // trainers:
        Trainer trainerOne = new Trainer("Bob");
        Trainer trainerTwo = new Trainer("Todd");
        Trainer trainerThree = new Trainer("Rod");

        List<Trainer> trainerList = new ArrayList<>(Arrays.asList(trainerOne, trainerTwo, trainerThree));

        Map<String, Trainer> mappedTrainers = mapNameToGenericInput(trainerList);
        mappedTrainers.forEach((key, value) -> System.out.println(key + ": " + value.toString()));

        // runners:
        List<Runner> runners = Collections.synchronizedList(new ArrayList<>());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        runners.add(Runner.getRunnerById(runnerId));

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        Map<String, Runner> mappedRunners = mapNameToGenericInput(runners);
        mappedRunners.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }

    private static <T extends Person> Map<String, T> mapNameToGenericInput(List<T> list) {
        Map<String, T> mappedInput = new HashMap<>();
        list.forEach(x -> mappedInput.put(x.getName(), x));

        return mappedInput;

    }

    private static void sixthTask(Set<String> runnerIds) {
        AtomicInteger numberTwo = new AtomicInteger();
        List<Runner> allRunners = Collections.synchronizedList(new ArrayList<>());
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (String runnerId : runnerIds) {
                executorService.submit(() -> {
                    try {
                        int year = (int) Math.floor(Math.random() * (2006 - 1950 + 1) + 1950);
                        int month = (int) Math.floor(Math.random() * 13);
                        int day = (int) Math.floor(Math.random() * 31);
                        Runner newRunner = Runner.Builder.builder()
                                .withName(Runner.getRunnerById(runnerId).getName())
                                .withPersonalId(runnerId)
                                .withBirthDate(LocalDate.of(year, month, day))
                                .withStartingNumber(numberTwo.incrementAndGet())
                                .build();

                        allRunners.add(newRunner);

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        List<Function<Runner, Integer>> pointCalculators = getCalculations();
        Map<Runner, Integer> runnerPointsMap = countRunnersScore(allRunners, pointCalculators);

        List<Runner> allRunnersFinal = new ArrayList<>();
        runnerPointsMap.forEach((key, value) -> {
            int position = switch (value) {
                case 6 -> 1;
                case 5 -> 2;
                case 4 -> 3;
                case 3 -> 4;
                case 2 -> 5;
                case 1 -> 6;
                default -> 0;
            };

            Runner runner = Runner.Builder.builder()
                    .withName(key.getName())
                    .withBirthDate(key.getBirthDate())
                    .withStartingNumber(key.getStartingNumber())
                    .withAdvantagePoints(value)
                    .withPersonalId(key.getPersonalId())
                    .withFinalPosition(position)
                    .build();

            allRunnersFinal.add(runner);
        });

        allRunnersFinal.stream()
                .sorted(Comparator.comparing(Runner::getAdvantagePoints).reversed())
                .forEach(System.out::println);
    }

    private static List<Function<Runner, Integer>> getCalculations() {
        Function<Runner, Integer> weekendCalculation = Runner -> {
            DayOfWeek day = Runner.getBirthDate().getDayOfWeek();
            if (day.equals(DayOfWeek.SATURDAY) || day.equals(DayOfWeek.SUNDAY)) {
                return 3;
            }
            return 0;
        };

        Function<Runner, Integer> winterCalculation = Runner -> {
            int month = Runner.getBirthDate().getMonthValue();
            if (month != 12 && month != 1 && month != 2) {
                return 2;
            }
            return 0;
        };

        Function<Runner, Integer> startingPointCalculation = Runner -> {
            if (Runner.getStartingNumber() > 0 && Runner.getStartingNumber() < 26) {
                return 1;
            }
            return 0;
        };

        return new ArrayList<>(Arrays.asList(weekendCalculation, winterCalculation, startingPointCalculation));
    }

    private static <E> Map<E, Integer> countRunnersScore(List<E> runnerList, List<Function<E, Integer>> pointsCalculators) {
        Map<E, Integer> mappedRunnersPoints = new HashMap<>();
        runnerList.forEach(runner -> {
            int score = 0;
            for (Function<E, Integer> pointsCalculator : pointsCalculators) {
                score += pointsCalculator.apply(runner);
            }
            mappedRunnersPoints.put(runner, score);
        });

        return mappedRunnersPoints;
    }
}
