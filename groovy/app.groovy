@RestController

class QuickDemo {

  @RequestMapping("/")
  String hello() {
    return "Quick"
  }

}
