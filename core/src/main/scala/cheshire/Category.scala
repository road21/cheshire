package cheshire

import scala.{AnyKind}

trait FunctionK[F[_ <: AnyKind], G[_ <: AnyKind]] {
  def apply[A <: AnyKind](fa: F[A]): G[A]
}

trait FunctionB[F[_ <: AnyKind, _ <: AnyKind], G[_ <: AnyKind, _ <: AnyKind]] {
  def apply[A <: AnyKind, B <: AnyKind](fab: F[A, B]): G[A, B]
}

// FIXME: This should be a type alias of `Monoid`, but I don’t know what the
//        correct identity object is.
trait Category[⟶[_ <: AnyKind, _ <: AnyKind]]
    extends SemigroupB[FunctionB, ComposeB[⟶, ⟶, ?, ?], ⟶] {
  def identity[A]: A ⟶ A
}
