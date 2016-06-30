/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.models;

import org.apache.wicket.model.IModel;

public class PersonModel implements IModel
{

	private IModel personContainingModel;
	private PersonModelType type;

	public enum PersonModelType {
		NAME_MODEL, AGE_MODEL, ADDRESS_MODEL;
	}

	public PersonModel(IModel personContainingModel, PersonModelType type)
	{
		this.personContainingModel = personContainingModel;
		this.type = type;
	}

	@Override
	public Object getObject()
	{
		Person person = (Person)personContainingModel.getObject();

		switch (type)
		{

			case NAME_MODEL :

				return person.getName();

			case AGE_MODEL :
				return new Integer(person.getAge());

			case ADDRESS_MODEL :
				return person.getAddress();

		}

		throw new UnsupportedOperationException("invalid PersonModelType = " + type.name());
	}

	@Override
	public void setObject(Object object)
	{

		Person person = (Person)personContainingModel.getObject();

		switch (type)
		{

			case NAME_MODEL :

				person.setName((String)object);
				break;

			case AGE_MODEL :
				person.setAge((Integer)object);
				break;

			case ADDRESS_MODEL :
				person.setAddress((Address)object);
				break;

			default :
				throw new UnsupportedOperationException("invalid PersonModelType = " + type.name());
		}

	}

	@Override
	public void detach()
	{
		personContainingModel.detach();
	}

}