def WithPreAndPostFunction(origin_function):
    def WrappedFunction(cls):
        print('before')
        function = origin_function(cls)
        print('after')
        return function
    return WrappedFunction

def WithAllTestFunctionWrapped(cls):
    for attr_name in dir(cls):
        attr_value = getattr(cls, attr_name)
        if hasattr(attr_value, '__call__') and attr_value.__name__.startswith('test'):
            setattr(cls, attr_name, WithPreAndPostFunction(attr_value))
    return cls

@WithAllTestFunctionWrapped
class Base:
    def OriginFunction(self):
        print('origin function')

    def testOriginFunction(self):
        self.OriginFunction()

    def testOriginFunction2(self):
        self.OriginFunction()

if __name__ == '__main__':
    base = Base()
    base.OriginFunction()
    base.testOriginFunction()
    base.testOriginFunction2()
