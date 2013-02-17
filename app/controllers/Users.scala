package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._

object Users extends Controller {
	val db = Json.arr(
		Json.obj( "id" -> "1", "name" -> "John" ),
		Json.obj( "id" -> "2", "name" -> "Suzanne" )
	)

	def all() = Action {
		Ok(db)
	}

	def find(id: String) = Action {
		Ok(db.value.filter(value => (value \ "id").as[JsString].value == id).headOption.getOrElse(new JsUndefined("")))
	}
}
