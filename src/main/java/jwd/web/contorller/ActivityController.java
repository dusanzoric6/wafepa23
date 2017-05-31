//package jwd.web.contorller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import jwd.model.Activity;
//import jwd.service.ActivityService;
//
///**
// * Created by Dusan on 5/23/2017.
// */
//@RestController
//@RequestMapping(value= "/activities")
//public class ActivityController {
//
//  @Autowired
//  ActivityService activityService;
//
//  @RequestMapping(method = RequestMethod.GET)
//    ResponseEntity<List<Activity>> findAll (){
//    List<Activity> activities = activityService.findAll();
//
//    if (activities == null || activities.isEmpty()){
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    return new ResponseEntity<>(activities, HttpStatus.OK);
//  }
//
//  @RequestMapping( value = "/{id}", method = RequestMethod.GET)
//  ResponseEntity<Activity> getActivity (@PathVariable Long id){
//    Activity activity = activityService.findOne(id);
//
//    if (activity== null ){
//      return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
//    }
//
//    return new ResponseEntity<>(activity, HttpStatus.OK);
//
//  }
//  @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    ResponseEntity<Activity> delete(@PathVariable Long id){
//    Activity activity = activityService.delete(id);
//    if (activity == null){
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//    return new ResponseEntity<>(activity, HttpStatus.OK);
//  }
//
//  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//  ResponseEntity<Activity> add(@RequestBody Activity newActivity){
//      Activity saved = activityService.save(newActivity);
//      return new ResponseEntity<Activity>(saved,HttpStatus.CREATED);
//  }
//
//  @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
//  ResponseEntity<Activity> edit (@RequestBody Activity editedActivity, @PathVariable Long id){
//
//    if(id!= editedActivity.getId()){
//      return new ResponseEntity<Activity>(HttpStatus.BAD_REQUEST);
//    }
//
//    Activity persisted = activityService.save(editedActivity);
//    return new ResponseEntity<Activity>(persisted, HttpStatus.OK);
//
//  }
//
//}
