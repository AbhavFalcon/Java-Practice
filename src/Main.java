import java.util.Optional;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Output Completable Future Code:");

        CompletableFuture.supplyAsync(()->{
            return "HI!";
        }).thenApply(greeting->{
            return greeting+" I'm a greeting";
        }).thenAccept(System.out::println);

        System.out.println();

//        Future: what happens is a task is given executor service and it starts running in a background thread ,
//        .get() is called to get result
        System.out.println("Future Practice:");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future= executorService.submit(()->{
            Thread.sleep(2000);
            return "Hello World";
        });

        System.out.println("Doing something else....");

        String result= future.get();
        System.out.println(result);
        executorService.shutdown();

        System.out.println();

//        String Memory mgmt here string is stored as pool rather storing it again again it saves memory ,
//        using new to create string will store the string outside the pool and intern is used to force the new string into the pool
        System.out.println("String Memory Management:");
        String a="Java";
        String b="Java";
        String c=new String("Java");
        String d=new String("Java").intern();

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));


        System.out.println();

//        Fork Join Factorial Practice
        System.out.println("Fork Join :");
        int nums= 10;
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinPrac task= new ForkJoinPrac(1,nums);
        long answer=forkJoinPool.invoke(task);
        System.out.println(result);


        System.out.println();

//        Optional Practice
        System.out.println("Optional Practice: ");
        UserService service = new UserService();
        int[] testIds={1,3};

        for(int id:testIds){  // for each loop
            Optional<User> optionalUser = service.findUserByInt(id);

            optionalUser.ifPresent(user -> System.out.println("User Found: "+user.getName()));
            String name = optionalUser.map(User::getName).orElse("User not found");
            System.out.println("Lookup result: " + name);

            // Or throw if not found
            try {
                String sureName = optionalUser.map(User::getName)
                        .orElseThrow(() -> new RuntimeException("User with ID " + id + " not found!"));
                System.out.println("Forced name: " + sureName);
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            System.out.println("---------------");
        }
        System.out.println();

        System.out.println();

        System.out.println("Streams: ");
        Streams streams = new Streams();
        streams.stream();

        System.out.println("Interface: ");
        // Call interface static method on Interface
        DefaultStaticExampleInterface.display();
        DefaultStaticExampleClass defaultStaticExampleClass = new DefaultStaticExampleClass();

        // Call default method on Class
        defaultStaticExampleClass.show();

        System.out.println("Producers and Consumers: ");
        ProducersConsumer producersConsumer = new ProducersConsumer();
        producersConsumer.blockingQueue();



//        Producers And Consumers use of BlockingQueue is important becoz built in blocking put and take plus no need to extra synchronisation


//        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
//        Random random = new Random();
//        Supplier<String> producer = () -> "Message- " + random.nextInt(100);
//        Consumer<String> consumer = message -> {
//            String time = LocalTime.now().withNano(0).toString();
//            System.out.println("{"+time+"}"+message);
//        };
//        new Thread(() -> {
//            while (true) {
//                try{
//                   String message=producer.get();
//                   queue.put(message);
//                   Thread.sleep(2000);
//                }catch (InterruptedException e) {}
//            }
//        }).start();
//        new Thread(() -> {
//            while (true) {
//                try {
//                    String message = queue.take(); // blocks if queue is empty
//                    consumer.accept(message);
//                }catch (InterruptedException e) {}
//
//            }
//
//        }).start();




//        Use of Streams


//        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
//        List<String> result= names.stream()
//                .filter(name -> name.startsWith("A"))
//                .map(String::toUpperCase)
//                .collect(Collectors.toList());
//
//        System.out.println(result);
//        List<String> result = new ArrayList<>();
//
//        for (String name : names) {
//            if (name.startsWith("B")||name.startsWith("C")) {
//                result.add(name.toUpperCase());
//            }
//        }
//        System.out.println(result);
    }
}