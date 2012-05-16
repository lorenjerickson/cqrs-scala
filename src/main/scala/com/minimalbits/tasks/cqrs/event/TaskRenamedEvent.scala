/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.event

class TaskRenamedEvent(val id:String, val name:String) extends DomainEvent {

}
