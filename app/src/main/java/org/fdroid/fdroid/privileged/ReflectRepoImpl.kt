package org.fdroid.fdroid.privileged

import java.lang.reflect.Constructor
import java.lang.reflect.Field
import java.lang.reflect.Method

class ReflectRepoImpl {
     fun getConstructors(clazz: Class<*>): Array<Constructor<*>> = clazz.constructors
     fun getDeclaredConstructors(clazz: Class<*>): Array<Constructor<*>> =
        clazz.declaredConstructors

     fun getFields(clazz: Class<*>): Array<Field> = clazz.fields

     fun getDeclaredFields(clazz: Class<*>): Array<Field> = clazz.declaredFields

     fun getMethods(clazz: Class<*>): Array<Method> = clazz.methods

     fun getDeclaredMethods(clazz: Class<*>): Array<Method> = clazz.declaredMethods

     fun getConstructor(clazz: Class<*>, vararg parameterTypes: Class<*>): Constructor<*>? {
        for (constructor in getConstructors(clazz)) {
            val expectedTypes = constructor.parameterTypes
            if (expectedTypes.size != parameterTypes.size) continue
            for (i in expectedTypes.indices)
                if (expectedTypes[i] != parameterTypes[i]) continue
            return constructor
        }
        return null
    }

     fun getDeclaredConstructor(
        clazz: Class<*>,
        vararg parameterTypes: Class<*>
    ): Constructor<*>? {
        for (constructor in getDeclaredConstructors(clazz)) {
            val expectedTypes = constructor.parameterTypes
            if (expectedTypes.size != parameterTypes.size) continue
            for (i in expectedTypes.indices)
                if (expectedTypes[i] != parameterTypes[i]) continue
            return constructor
        }
        return null
    }

     fun getField(clazz: Class<*>, name: String): Field? {
        for (field in getFields(clazz)) {
            if (field.name != name) continue
            return field
        }
        return null
    }

     fun getDeclaredField(clazz: Class<*>, name: String): Field? {
        for (field in getDeclaredFields(clazz)) {
            if (field.name != name) continue
            return field
        }
        return null
    }

     fun getMethod(
        clazz: Class<*>,
        name: String,
        vararg parameterTypes: Class<*>
    ): Method? {
        for (method in getMethods(clazz)) {
            if (method.name != name) continue
            val expectedTypes = method.parameterTypes
            if (expectedTypes.size != parameterTypes.size) continue
            for (i in expectedTypes.indices)
                if (expectedTypes[i] != parameterTypes[i]) continue
            return method
        }
        return null
    }

     fun getDeclaredMethod(
        clazz: Class<*>,
        name: String,
        vararg parameterTypes: Class<*>
    ): Method? {
        for (method in getDeclaredMethods(clazz)) {
            if (method.name != name) continue
            val expectedTypes = method.parameterTypes
            if (expectedTypes.size != parameterTypes.size) continue
            for (i in expectedTypes.indices)
                if (expectedTypes[i] != parameterTypes[i]) continue
            return method
        }
        return null
    }
}