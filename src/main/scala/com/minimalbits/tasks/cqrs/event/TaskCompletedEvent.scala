package com.minimalbits.tasks.cqrs.event

/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 */

class TaskCompletedEvent(val id:String, val completed:Boolean) extends DomainEvent {

}
