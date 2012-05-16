/**
 * Created with IntelliJ IDEA.
 * User: a239597
 * Date: 5/16/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */

package com.minimalbits.tasks.cqrs.command

class CompleteTaskCommand(val id:String, val expectedVersion:Int) extends BaseCommand {

}

