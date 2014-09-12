namespace TeslaTest
{
    using System;
    using Rhino.Mocks;

    /// <summary>
    /// Contains the implementation of all mock and stub objects.
    /// </summary>
    /// <remarks>
    /// We want to keep all mock and stub-object generation within this
    /// helper class to ensure we don't build deep dependencies throughout
    /// the test code to a specific mock framework (e.g: Rhink Mocks). Also
    /// makes dealing with mock framework upgrades an easier affair.
    /// </remarks>
    public class MockObjects
    {
        /// <summary>
        /// Creates a mock <see cref="System.IO.Stream"/> that throws on a write call.
        /// </summary>
        /// <param name="e">Exception to be thrown.</param>
        /// <param name="skipNullableCheck">If <c>true</c>, do not throw on the nullable byte write but on the next write call.</param>
        /// <returns>Mock stream.</returns>
        public static System.IO.Stream CreateMockStreamThrowsOnWrite(Exception e, bool skipNullableCheck)
        {
            System.IO.Stream stream = MockRepository.GeneratePartialMock<System.IO.Stream>();

            stream.Stub(s => s.CanWrite)
                .Return(true);                

            stream.Stub(s => s.Write(Arg<byte[]>.Is.Anything, Arg<int>.Is.Anything, Arg<int>.Is.Anything))
                .Throw(e);

            stream.Stub(s => s.WriteByte(Arg<byte>.Is.Anything))
                .Repeat.Times(skipNullableCheck ? 1 : 0);

            stream.Stub(s => s.WriteByte(Arg<byte>.Is.Anything))
                .Throw(e);

            return stream;
        }

        /// <summary>
        /// Creates a mock <see cref="System.IO.Stream"/> that throws on a read call.
        /// </summary>
        /// <param name="e">Exception to be thrown.</param>
        /// <param name="skipNullableCheck">If <c>true</c>, do not throw on the nullable byte read but on the next read call.</param>
        /// <returns>Mock stream.</returns>
        public static System.IO.Stream CreateMockStreamThrowsOnRead(Exception e, bool skipNullableCheck)
        {
            System.IO.Stream stream = MockRepository.GeneratePartialMock<System.IO.Stream>();

            stream.Stub(s => s.CanRead)
                .Return(true);

            stream.Stub(s => s.Read(Arg<byte[]>.Out(null).Dummy, Arg<int>.Is.Anything, Arg<int>.Is.Anything))
                .IgnoreArguments()
                .Throw(e);

            if (skipNullableCheck)
            {
                stream.Stub(s => s.ReadByte())
                    .Return(0x5)
                    .Repeat.Once();
            }

            stream.Stub(s => s.ReadByte())
                .Throw(e);

            return stream;
        }
    }
}
